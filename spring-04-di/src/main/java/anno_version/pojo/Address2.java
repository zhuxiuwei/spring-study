package anno_version.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address2 {
    @Value("地址by注解")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   @Override
   public String toString() {
       return "Address{" +
               "address='" + address + '\'' +
               '}';
   }
}
