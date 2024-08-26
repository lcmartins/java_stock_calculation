package capitalgain.adapters;

import capitalgain.adapters.request.OperationRequest;
import capitalgain.domain.entities.Operation;
import capitalgain.domain.ports.IOperationReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OperationFileReader implements IOperationReader {

    private final String file;

    public OperationFileReader(String file) {
        this.file = file;
    }
    public List<Operation> read() {
        List<Operation> OperationRequests = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));

            String line = bufferedReader.readLine();

            while(line != null){
                OperationRequest r = new ObjectMapper().reader().readValue(line, OperationRequest.class);
                OperationRequests.add(r.parseToDomain());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return OperationRequests;
    }
}
