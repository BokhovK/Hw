package pro.sky.employees.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.employees.Exception.IncorrectNameException;

@Service
public class ValidationService {
    public String validate (String name){
        if(StringUtils.isAlpha(name)){
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }
}
