package pro.sky.model.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.exception.ValidationFailedException;

@Service
public class ValidationService {
    public String validateCheckName(String name){
        name = name.trim();
        if (!StringUtils.isAlpha(name)){
            throw new ValidationFailedException();

        }
      return StringUtils.capitalize(name.toLowerCase());
    }
}
