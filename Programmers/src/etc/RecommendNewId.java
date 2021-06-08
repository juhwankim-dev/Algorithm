package etc;

public class RecommendNewId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static String solution(String new_id) {
        // 1�ܰ�
        new_id = new_id.toLowerCase();
       
        // 2�ܰ�
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3�ܰ�
        while(new_id.contains("..")) {
        	new_id = new_id.replace("..", ".");
        }
        
        // 4�ܰ�
        if(!new_id.isEmpty() && new_id.charAt(0) == '.')
        	new_id = new_id.substring(1, new_id.length());
        
        if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.')
        	new_id = new_id.substring(0, new_id.length()-1);
        
        // 5�ܰ�
        if(new_id.isEmpty()) new_id = "a";
        
        // 6�ܰ�
        if(new_id.length() >= 16) {
        	new_id = new_id.substring(0, 15);
        	if(new_id.charAt(14) == '.') {
        		new_id = new_id.substring(0, 14);
        	}
        }
        
        // 7�ܰ�
        char lastChar = new_id.charAt(new_id.length()-1);
        while(new_id.length() <= 2) {
        	new_id += lastChar;
        }
        
        return new_id;
    }
}
