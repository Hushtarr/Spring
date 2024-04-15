package App.Model;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
public class employee
    {
    private UUID employee_id;
    private String employee_name;
    private String employee_address;
    private String employee_city;
    private String employee_state;
    private UUID employee_phone;
    private String employee_email;

    }
