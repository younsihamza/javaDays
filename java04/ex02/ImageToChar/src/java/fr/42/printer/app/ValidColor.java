package app;
import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class ValidColor implements IParameterValidator {
  public  void validate(String name, String value) throws ParameterException {
      try {
        System.out.println(value);
          Ansi.FColor.valueOf(value);
      } catch (Exception e) {
          throw new ParameterException("Parameter " + name + " should be a valid color and uppercase (found " + value + ")");
      }
  }
}