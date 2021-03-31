class Solution {
    public int numUniqueEmails(String[] emails) {

        ArrayList<String> actualUniqueEmails = new ArrayList<String>();
        int differentEmailsCounter = 0;

        for(int i = 0; i < emails.length; i++)
        {
            //1.1 split email into two parts (local and domain) by using the @ symbol
            String[] splitEmail = emails[i].split("@");
            //1.2 remove everything after a "+"
            String localPart = splitEmail[0];
            localPart = localPart.split("\\+")[0];
            //1.3 remove any dot in the local part
            localPart = localPart.replaceAll("\\.","");
            //1.4 merge back email
            String actualEmail = localPart+"@"+splitEmail[1];
            //1.5 if mail doesnt exist in actual emails add into actualUniqueEmails array
            // And increment differentEmailsCounter
            boolean exists = false;
            for(String email : actualUniqueEmails){
                if(email.equals(actualEmail)){
                    exists = true;
                }
            }
            if(!exists){
                actualUniqueEmails.add(actualEmail);
                differentEmailsCounter++;
            }
        }
        System.out.println(actualUniqueEmails.toString());
        // 2 return differentEmailsCounter
        return differentEmailsCounter;
    }
}