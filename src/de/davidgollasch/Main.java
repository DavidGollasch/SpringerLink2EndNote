package de.davidgollasch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

	    if(args.length <= 0) {
	        System.out.println("Please give an input file.");
            return;
        }

        String filename = args[0];
        File file = new File(filename);
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            System.out.println("File cannot be opened. Sorry.");
            return;
        }

        List<String> lines = new ArrayList<>();
        String currentline = "";
        try {
            while ((currentline = reader.readLine()) != null) {
                lines.add(currentline);
            }
        } catch (Exception e) {
            System.out.println("Error reading a line of the file. Sorry.");
        }

        lines.remove(0); // removes headline
        List<List<String>> fields = new ArrayList<>();

        for (String l : lines) {
            String[] arrFields = l.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            List<String> lsFields = new ArrayList<>();
            for(int i=0; i<arrFields.length; i++) {
                String temp = arrFields[i];

                // cut off first end last quotation marks
                if(temp.endsWith("\""))
                    temp = temp.substring(0, temp.length()-1);
                if(temp.startsWith("\""))
                    temp = temp.substring(1);

                lsFields.add(temp);
            }
            fields.add(lsFields);
        }

        for(List<String> f : fields) {

            System.out.print("%0 "); // type                     _9
            /*
            Chapter
            Article
             */
                if(f.get(9).equals("Chapter")) {
                    System.out.print("Book Section");
                } else if(f.get(9).equals("Article")) {
                    System.out.print("Electronic Article");
                } else {
                    System.out.print(f.get(9));
                }

            System.out.println("");
            System.out.print("%A "); // author                   _6
            System.out.print(f.get(6));
            System.out.println("");
            System.out.print("%D "); // year                     _7
            System.out.print(f.get(7));
            System.out.println("");
            System.out.print("%T "); // titel                    _0
            System.out.print(f.get(0));
            System.out.println("");
            System.out.print("%B "); // published in             _1
            System.out.print(f.get(1));
            System.out.println("");
            System.out.print("%J "); // Journal name             _2
            System.out.print(f.get(2));
            System.out.println("");
            System.out.print("%V "); // Journal volume           _3
            System.out.print(f.get(3));
            System.out.println("");
            System.out.print("%7 "); // Journal edition/issue    _4
            System.out.print(f.get(4));
            System.out.println("");
            System.out.print("%R "); // DOI                      _5
            System.out.print(f.get(5));
            System.out.println("");
            System.out.print("%U "); // URL                      _8
            System.out.print(f.get(8));
            System.out.println("");
            System.out.println("");
        }
    }
}
