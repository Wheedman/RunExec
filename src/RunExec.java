import java.io.IOException;
import java.io.InputStream;

public class RunExec {

    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("Exec/teamscale-timestamp");
        // This is as same as what we do at DOS Prompt.
        InputStream is = p.getInputStream();
        int n = 0;
        while(n != -1)
        {
            n = is.read();
            System.out.print(n);
        }

    }
}
