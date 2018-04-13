package examples;

import gov.nih.nlm.nls.skr.GenericObject;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MedicalTextIndexer {
    // 通过用户名、密码、邮箱、txt文件路径，返回结果
    public String getResults(String username, String password, String email, String filename) {
        GenericObject myGenericObj = new GenericObject(username, password);

        myGenericObj.setField("Email_Address", email);
        myGenericObj.setFileField("UpLoad_File", filename); //绝对路径
        myGenericObj.setField("Batch_Command", "MTI -opt1L_DCMS -E");
        myGenericObj.setField("BatchNotes", "SKR Web API test");
        myGenericObj.setField("SilentEmail", true);
        // myGenericObj.setField("SingLinePMID", true);

        try {
            String results = myGenericObj.handleSubmission();
//            System.out.println(results);
            return results;
        } catch (RuntimeException ex) {
            System.err.println("");
            System.err.print("An ERROR has occurred while processing your");
            System.err.println(" request, please review any");
            System.err.print("lines beginning with \"Error:\" above and the");
            System.err.println(" trace below for indications of");
            System.err.println("what may have gone wrong.");
            System.err.println("");
            System.err.println("Trace:");
            ex.printStackTrace();
        }

        return "";
    }

    public String[] getFilenames(String inputPath) {
        File file = new File(inputPath);
        String[] fileNames = file.list();
//        Arrays.sort(fileNames);
//        for(int i = 0; i < fileNames.length; i++) {
//            System.out.println(fileNames[i]);
//        }
        return fileNames;
    }

    // 通过txt文件目录名批量处理
    public void getResultsBatch(String inputPath, String outputPath, String[] fileNames, int start, int end) {
        String username = "";
        String password = "";
        String email = "";

//        File file = new File(inputPath);
//        String[] fileNames = file.list();

        for(int i = (start-1); i < (end-1); i++) {
            String filename = fileNames[i];
            Path inPath = Paths.get(inputPath, filename);
            Path outPath = Paths.get(outputPath, filename);
            File outfile = new File(outPath.toString());
            if (outfile.exists()) {
                System.out.println(outPath.toString() + " exists! i = " + i);
                continue;
            }
            String results = getResults(username, password, email, inPath.toString());
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeFile(results, outPath.toString());

            System.out.println(outPath.toString() + " save success! i = " + i + " ********");
        }
        System.out.println("All tags get success!");
    }

    public static void main(String[] args) {
        String inputPath = "/Users/wanglei/Documents/IdeaProjects/MTI/data/report10";
        String outputPath = "/Users/wanglei/Documents/IdeaProjects/MTI/data/tag10";

        MedicalTextIndexer mti = new MedicalTextIndexer();
        String[] fileNames = mti.getFilenames(inputPath);
        mti.getResultsBatch(inputPath, outputPath, fileNames, 0, 5);
    }
}
