package examples;

public class MyThreads extends Thread {
    private String threadName;
    private String inputPath;
    private String outputPath;
    private String[] fileNames;
    private int start;
    private int end;

    public MyThreads(String name, String inputPath, String ouputPath, String[] fileNames, int start, int end) {
        this.threadName = name;
        this.inputPath = inputPath;
        this.outputPath = ouputPath;
        this.fileNames = fileNames;
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("Running: " +  threadName );
        try {
            MedicalTextIndexer mti = new MedicalTextIndexer();
            mti.getResultsBatch(inputPath, outputPath, fileNames, start, end);

            Thread.sleep(100);

        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
            e.printStackTrace();
        }
        System.out.println(threadName + " exiting.");
    }

    public static void main(String[] args) {
        String inputPath = "/Users/wanglei/Documents/IdeaProjects/MTI/data/report10";
        String outputPath = "/Users/wanglei/Documents/IdeaProjects/MTI/data/tag10";
        MedicalTextIndexer mti = new MedicalTextIndexer();
        String[] fileNames = mti.getFilenames(inputPath);
        int len = fileNames.length;
        int batch = 10;
        System.out.println(len);
        for(int i = 0; i <= 9; i++) {
            String threadName = "Thread" + i;
            int start = i*(len/batch) + 1;
            int end = (i+1)*(len/batch) + 1;
            if(end > len) {
                end = len+1;
            }
            System.out.println(start + ", " + end);

            MyThreads thread = new MyThreads(threadName, inputPath, outputPath, fileNames, start, end);
            thread.start();
        }

//        MyThreads threads1 = new MyThreads("Thread1", inputPath, outputPath, fileNames,1, 4);
//        threads1.start();
//
//        MyThreads threads2 = new MyThreads("Thread2", inputPath, outputPath, fileNames, 5, 7);
//        threads2.start();
//
//        MyThreads threads3 = new MyThreads("Thread3", inputPath, outputPath, fileNames, 8, 10);
//        threads3.start();
    }
}
