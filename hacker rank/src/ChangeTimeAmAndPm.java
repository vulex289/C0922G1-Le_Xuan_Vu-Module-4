package giaiThuat.hackerRank;

public class ChangeTimeAmAndPm {
    public static void main(String[] args) {
String a = "07:35:45PM";
        System.out.println(timeConversion(a));
    }

    public static String timeConversion(String s) {
        // Write your code here
        String a = "";
        String arr[] = s.split(":");
        if (arr[2].contains("AM")) {
         if (arr[0].equals("12")){
             arr[0] = "00";
         }
        }
        if (arr[2].contains("PM")) {
            switch (arr[0]) {
                case "01":
                    arr[0] = "13";
                    break;
                case "02":
                    arr[0] = "14";
                    break;
                case "03":
                    arr[0] = "15";
                    break;
                case "04":
                    arr[0] = "16";
                    break;
                case "05":
                    arr[0] = "17";
                    break;
                case "06":
                    arr[0] = "18";
                    break;
                case "07":
                    arr[0] = "19";
                    break;
                case "08":
                    arr[0] = "20";
                    break;
                case "09":
                    arr[0] = "21";
                    break;
                case "10":
                    arr[0] = "22";
                    break;
                case "11":
                    arr[0] = "23";
                    break;
                default:
                    break;
            }
        }
        String arr2[] = arr[2].split("",3);
        String arr3 = arr2[0]+arr2[1];
         a = arr[0] + ":"+arr[1]+":"+arr3;
        return a;
    }
}
