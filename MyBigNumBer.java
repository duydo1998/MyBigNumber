package javaapplication1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 *
 * Author: Duy Do
 * Trong class có một hàm là hàm sum.
 * 
 */

public class MyBigNumber {

    /** 
     * 
     * Cộng các số từ hai chuôi. 
     * Không giới hạn độ dài hai chuỗi.
     * 
     */
    
    public String sum(final String n1, final String n2) {
        // Xử lý hai hàm chuỗi 
        // Tạo biến final
        String step = "";// Chuỗi step sẽ làm tham số cho hàm send của interface
        String conver = "";       
        int x1;        // Số của char1 ở vị trí index1
        int x2;        // Số của char2 ở trị ví index2        
        int sumtamthoi;    // Tổng tạm của số thứ nhất và số thứ hai;
        
        int cong;       // Biến nhớ nếu tổng tạm < 10                
        int nho = 0;    // Biến nhớ nếu sumtamthoi >= 10   
        
        int index1;     // Vị trí đang chạy của số thứ 1
        int index2;     // Vị trí đang chạy của số thứ 2
        
        char char1;     // kí tự vị trí 1 của chuỗi số thứ nhất
        char char2;     // kí tự vị trí 2 của chuỗi số thứ hai
        
        int len1 = n1.length();// Độ dài của số thứ 1
        int len2 = n2.length();// Độ dài của số thứ 2
        int nho2=0;
        int maxLen = (len1 > len2) ? len1 : len2; // Tìm độ dài của 2 số
        String dapan = ""; // Hiển thị chuỗi đáp án của cộng 2 số        
        int j = 1;
        final String kytu = "\\d+"; // Chuỗi đại diện cho kí tự số từ [0-9]
        final boolean f1;           // Lưu dữ kết quả xét chuỗi s1 
        final boolean f2;           // Lưu dữ kết quả xét chuỗi s2
        //        
        // Lặp số lần của chuỗi dài nhất
        //
        for (int i = 0; i < maxLen; i++) {
            index1 = len1 - i - 1; //index1 của chuỗi 1
            index2 = len2 - i - 1; //index2 của chuỗi 2

            char1 = (index1 >= 0) ? n1.charAt(index1) : '0'; //Ký tự char1 ở vị trí i
            char2 = (index2 >= 0) ? n2.charAt(index2) : '0'; //Ký tự char2 ở vị trí i

            x1 = char1 - '0'; //Bảng mã ASCII chữ thứ nhất vị trí số char1
            x2 = char2 - '0'; //Bảng mã ASCII chữ thứ hai vị trí số char2

            sumtamthoi = x1 + x2 + nho; // Tổng cộng 2 số thứ nhất và số thứ 2 
            cong = x1 + x2; // Cộng tổng hai số

            dapan = (sumtamthoi % 10) + dapan; // Lấy số vừa tính gán vào biến dapan
            nho = sumtamthoi / 10; //Biến nhớ
            if (i == 0) {
                conver = "Bước " + j + " : lấy " + x1 + " cộng " + x2 + " được " + cong 
                    + " , " + " ghi " + (sumtamthoi % 10) + " , " + " nhớ " + nho + ", kết quả : " + dapan + "\n";
            } else if (i == (maxLen - 1) && sumtamthoi >= 10) {
                conver = "Bước " + j + " : lấy " + x1 + " cộng " + x2 + " cộng " + nho 
                    + " được " + sumtamthoi + " , " + "ghi " + (sumtamthoi % 10) + " , " + "nhớ " + nho + ", kết quả : 1" + dapan + "\n";
            } else {
                conver = "Bước " + j + " : lấy " + x1 + " cộng " + x2 + " cộng " + nho2 
                    + " được " + sumtamthoi + " , " + "ghi " + (sumtamthoi % 10) + " , " + "nhớ " + nho + ", kết quả : " + dapan + "\n";
            }
            nho2 = nho;
            step = step + conver;
            j++;
        }        
        //  
        //Nếu có biến nhớ ghép thêm biến nhớ vào phía trước đáp án
        //
        if (nho > 0) {
            dapan = nho + dapan; // Cộng số nhớ ở vị trí index = 1 
        }
        
        if (n1.contains("-")) {
            dapan ="Phần mềm chưa hỗ trợ số âm !";
        }
        if (n2.contains("-")) {
            dapan ="Phần mềm chưa hỗ trợ số âm !";
        }
        
        f1 = n1.matches(kytu);
        f2 = n2.matches(kytu);
        if (!f1) {
            dapan ="Vui lòng không nhập chữ hoặc ký tự đặt biệt !";
        }
        if (!f2) {
            dapan ="Vui lòng không nhập chữ hoặc ký tự đặt biệt !";
        }
        
        System.out.println(step);
        return dapan;
    } 
}