import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class RunExec {

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("Exec/teamscale-timestamp");
        // This is as same as what we do at DOS Prompt.
        InputStream is = p.getInputStream();
        StringBuilder build = new StringBuilder();
        int n = is.read();
        while(n != -1 && n != '\n')
        {

//            System.out.print((char) n);
            // Whatever
            build.append((char) n);
            n = is.read();
        }
        System.out.println(build.toString());
        System.out.println("build.toString()");
    }
}
