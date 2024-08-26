/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package capitalgain;

import capitalgain.adapters.ConsoleReader;
import capitalgain.adapters.ConsoleWriter;
import capitalgain.adapters.OperationFileReader;
import capitalgain.domain.entities.OperationCalculator;
import capitalgain.domain.entities.IOperationCalculator;
import capitalgain.domain.entities.Operation;
import capitalgain.domain.entities.Tax;
import capitalgain.domain.ports.IOperationReader;
import capitalgain.domain.ports.IOperationWriter;

import java.io.IOException;
import java.util.List;


public class App {

    public static void main(String[] args) throws IOException {

        IOperationCalculator operationCalculator = new OperationCalculator();
        IOperationWriter writer = new ConsoleWriter();
        IOperationReader reader;

        if (args.length > 0) {
            reader = new OperationFileReader(args[0]);
            List<Operation> operations = reader.read();
            List<Tax> taxes = operationCalculator.executeOperation(operations);
            writer.write(taxes);
            return;
        }

        reader = new ConsoleReader();

        List<Operation> operations = reader.read();
        List<Tax> taxes = operationCalculator.executeOperation(operations);
        writer.write(taxes);
    }
}
