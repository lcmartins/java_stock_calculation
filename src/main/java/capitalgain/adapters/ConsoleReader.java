package capitalgain.adapters;


import capitalgain.adapters.request.OperationRequest;
import capitalgain.domain.entities.Operation;
import capitalgain.domain.ports.IOperationReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements IOperationReader {

    public List<Operation> read() throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<Operation> OperationRequests = new ArrayList<>();

        String in = scanner.nextLine();

        while (!in.isBlank()) {

            try {
                OperationRequest request = new ObjectMapper().reader().readValue(in, OperationRequest.class);
                OperationRequests.add(request.parseToDomain());
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            in = scanner.nextLine();

        }
        return OperationRequests;
    }
}
