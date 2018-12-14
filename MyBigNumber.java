import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBigNumber {

    

    
    public String sum(final String s1, final String s2) {
        

        String result = "";
        int length1 = s1.length();
        int length2 = s2.length();
        final int max = (length1 > length2) ? length1 : length2;
        int du = 0;
        int pos1 = 0;// Vị trí chuỗi s1
        int pos2 = 0;// Vị trí chuỗi s2
        char c1;// kí tự c1 dùng để lấy kí tự cuối cùng của chuỗi s1
        char c2;// kí tự c2 dùng để lấy kí tự cuối cùng của chuỗi s2
        int tong = 0;// Khởi tạo biến tổng = 0 để cộng 2 kí tự cuối cùng lại với nhau
        
        int hieu = 0;

        // Kiểm tra từng kí tự của 2 chuỗi s1 và s2 có chữ không 
        for (int i = 0; i < length1 || i < length2; i++) {

            if (Character.isLetter(s1.charAt(i))) {
                
                throw new NumberFormatException(" không phải là số");
            }
        }

        for (int i = 0; i < length2; i++) {

            if (Character.isLetter(s2.charAt(i))) {
                
                throw new NumberFormatException(" không phải là số");
            }
        }

  
        
        
        // Kiểm tra số âm
        if (s1.charAt(0) == '-') {
            throw new NumberFormatException("Chưa hỗ trợ số âm s1: " + s1);
        } 
        
        if (s2.charAt(0) == '-') {
            throw new NumberFormatException("Chưa hỗ trợ số âm s2: " + s2);
        }

        
        for (int i = 0; i < max; i++) {
            pos1 = length1 - i - 1;// cập nhật lại vị trí chuỗi s1
            pos2 = length2 - i - 1;// cập nhật lại vị trí chuỗi s2

            //xem có >= 0 hay không
            c1 = (pos1 >= 0) ? s1.charAt(length1 - i - 1) : '0';
            c2 = (pos2 >= 0) ? s2.charAt(length2 - i - 1) : '0';

            tong = (c1 - '0') + (c2 - '0') + du;
            result = (tong % 10) + result;
            du = tong / 10;

           
        }

        if (du > 0) {
            result = du + result;// Nếu số nhớ còn dư thì ghép vào chuỗi kết quả
        }

        return result;
    }
}