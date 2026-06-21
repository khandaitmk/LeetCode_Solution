class Solution {
    public String intToRoman(int num) {
        HashMap<Integer , String> hm = new HashMap<>();
        hm.put(1,"I");
        hm.put(5,"V");
        hm.put(10,"X");
        hm.put(50 , "L");
        hm.put(100,"C");
        hm.put(500,"D");
        hm.put(1000,"M");
        hm.put(4,"IV");
        hm.put(9,"IX");
        hm.put(40,"XL");
        hm.put(90,"XC");
        hm.put(400 , "CD");
        hm.put(900 , "CM");

        StringBuilder str = new StringBuilder();

        if(hm.containsKey(num)) return hm.get(num);

        while(num != 0){
            if(num >= 1000){
                int rem = num % 1000;
                int temp = num - rem;
                int t = temp / 1000;
                while(t != 0){
                    str.append(hm.get(1000));
                    t--;
                }
                num = rem;
            }
            else if(num >= 900){
                int rem = num % 900;
                int temp = num - rem;
                int t = temp / 900;
                while(t != 0){
                    str.append(hm.get(900));
                    t--;
                }
                num = rem;
            }
            else if(num >= 500){
                int rem = num % 500;
                int temp = num - rem;
                int t = temp / 500;
                while(t != 0){
                    str.append(hm.get(500));
                    t--;
                }
                num = rem;
            }
            else if(num >= 400){
                int rem = num % 400;
                int temp = num - rem;
                int t = temp / 400;
                while(t != 0){
                    str.append(hm.get(400));
                    t--;
                }
                num = rem;
            }
            else if(num >= 100){
                int rem = num % 100;
                int temp = num - rem;
                int t = temp / 100;
                while(t != 0){
                    str.append(hm.get(100));
                    t--;
                }
                num = rem;
            }
            else if(num >= 90){
                int rem = num % 90;
                int temp = num - rem;
                int t = temp / 90;
                while(t != 0){
                    str.append(hm.get(90));
                    t--;
                }
                num = rem;
            }
            else if(num >= 50){
                int rem = num % 50;
                int temp = num - rem;
                int t = temp / 50;
                while(t != 0){
                    str.append(hm.get(50));
                    t--;
                }
                num = rem;
            }
            else if(num >= 40){
                int rem = num % 40;
                int temp = num - rem;
                int t = temp / 40;
                while(t != 0){
                    str.append(hm.get(40));
                    t--;
                }
                num = rem;
            }
            else if(num >= 10){
                int rem = num % 10;
                int temp = num - rem;
                int t = temp / 10;
                while(t != 0){
                    str.append(hm.get(10));
                    t--;
                }
                num = rem;
            }
            else if(num >= 9){
                int rem = num % 9;
                int temp = num - rem;
                int t = temp / 9;
                while(t != 0){
                    str.append(hm.get(9));
                    t--;
                }
                num = rem;
            }
            else if(num >= 5){
                int rem = num % 5;
                int temp = num - rem;
                int t = temp / 5;
                while(t != 0){
                    str.append(hm.get(5));
                    t--;
                }
                num = rem;
            }
            else if(num >= 4){
                int rem = num % 4;
                int temp = num - rem;
                int t = temp / 4;
                while(t != 0){
                    str.append(hm.get(4));
                    t--;
                }
                num = rem;
            }
            else if(num >= 1){
                int rem = num % 1;
                int temp = num - rem;
                int t = temp / 1;
                while(t != 0){
                    str.append(hm.get(1));
                    t--;
                }
                num = rem;
            }
        }
        return str.toString();
    }
}