public class Main {

    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        int phone1;
        int phone2;
        int phone3;
        int phone4;
        int phone5;
        int phone6;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Sidorov";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 231456;
            phone4 = 231457;
            phone5 = 231458;
            phone6 = 231459;
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            phone1 = Integer.parseInt(args[3]);
            phone2 = Integer.parseInt(args[4]);
            phone3 = Integer.parseInt(args[5]);
            phone4 = Integer.parseInt(args[6]);
            phone5 = Integer.parseInt(args[7]);
            phone6 = Integer.parseInt(args[8]);
        }

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name2, phone3);
        myPhoneBook.add(name2, phone4);
        myPhoneBook.add(name3, phone5);
        myPhoneBook.add(name3, phone6);

        myPhoneBook.find(name1);
        myPhoneBook.find("Me");
        System.out.println("\n");
        PhoneBook.getPhoneBook_sorted();
        System.out.println("\n");
        myPhoneBook.removePhone(phone2);
        myPhoneBook.removePhone(phone3);
        System.out.println("\n");
        PhoneBook.getPhoneBook_sorted();

    }
}