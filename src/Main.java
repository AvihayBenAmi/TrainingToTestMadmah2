import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bucket b1 = new Bucket();
        Bucket b2 = new Bucket();
        b1.setCapacity(7);
        b2.setCapacity(5);
        playBucketsGame();
    }

    public static void magic(Bucket b1, Bucket b2) {
        b1.fill();
        b2.fill(b1);
        b2.spill();
        b2.fill(b1);
        b1.fill();
        b2.fill(b1);
        b2.spill();
        b2.fill(b1);
        b1.fill();
        b2.fill(b1);
        b2.spill();
    }

    public Bucket reduceAmountInBuckets(Bucket[] buckets, float max) {
        Bucket newBucket = new Bucket();
        for (int i = 0; i < buckets.length; i++) {
            while ((buckets[i].precent() >= max))
                newBucket.fill(buckets[i]);
        }
        return newBucket;
    }

    public int[] fillExactAmount(Bucket[] buckets, int amount) {
        int counter = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].precent() >= 50) {
                if (buckets[i].getCurrent() == amount) {
                    counter++;
                }
            }
        }
        int[] array = new int[counter];
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].precent() >= 50) {
                if (buckets[i].getCurrent() == amount) {
                    array[k] = i;
                    k++;
                }

            }
        }
        return array;
    }

    public static void playBucketsGame() {
        Random random = new Random();
        Bucket[] buckets = new Bucket[4];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
            buckets[i].setCapacity(random.nextInt(1, 21));
            buckets[i].addLitrs(random.nextInt(1, buckets[i].getCapacity() + 1));
            System.out.println(buckets[i].toString());
        }
        int counter = 0;
        boolean check = true;
        while (counter != 4) {
            for (int i = 0; i < buckets.length; i++) {
                check = true;
                for (int j = i + 1; j < buckets.length; j++) {
                    if (buckets[i].getCapacity() == buckets[j].getCapacity()) {
                        buckets[j].setCapacity(random.nextInt(1, 21));
                        buckets[j].addLitrs(random.nextInt(1, buckets[j].getCapacity() + 1));
                        check = false;
                    }
                }
                if (check) {
                    counter++;
                }
            }
            if (counter < 4) {
                counter = 0;
            }
            buckets[3].spill();
        }
        boolean success = false;
        counter = 0;
        while (!success) {
            counter++;
            int rnd = random.nextInt(1, 21);
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i].getCurrent() + rnd == buckets[i].getCapacity()) {
                    success = true;
                }
            }
        }
        System.out.println("you success in " + counter + " times");
    }
}