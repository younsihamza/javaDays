import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static java.nio.file.StandardCopyOption.*;

public class Cmd {
    private String workDir = null;

    public Cmd(String workDir) {
        this.workDir = workDir;
    }

    public void ls(){
        try {

            Path pathOfWorkDir =  Paths.get(workDir);
            Stream<Path> listOfFiles = Files.list(pathOfWorkDir);
            listOfFiles.forEach((path)->{
                try {
                    System.out.println(path.getFileName() +" "+ String.format("%.2f KB" ,Files.size(path)/ 1024f));
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
            });
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void cd(String dist) {
        Path currenPath = Paths.get(this.workDir);
        Path distPath  = currenPath.resolve(dist).normalize();
        if(Files.exists(distPath)) 
            this.workDir = distPath.toString();
        else
            System.err.println("error : this diractory  not found ");
    }

    public void mv(String src ,String dist) {
        try{
            Path currenPath = Paths.get(this.workDir);
            Path srcPath = currenPath.resolve(src).normalize();
            Path distPath = currenPath.resolve(dist).normalize().resolve(srcPath.getFileName());
            if(!Files.exists(srcPath) || Files.isDirectory(srcPath)){
                System.out.println("ERROR: source file not found");
                return;
            }
            System.out.println("src : " + distPath.toString() + " : dist : " + srcPath.toString());
            Files.move(srcPath, distPath, REPLACE_EXISTING);
        } catch(Exception e) {
            System.err.println("ERROR : your distication not valide ");
        }
    }

    public String getWorkDir(){
        return this.workDir;
    }
}
