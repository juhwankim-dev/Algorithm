package etc;

public class SkillTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String reg = "[^" + skill +"]";

        for(int i=0; i<skill_trees.length; i++) {
        	String temp = skill_trees[i].replaceAll(reg, "");
        	
        	if(temp.isEmpty() || isAvailableSkillTree(skill, temp)) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
    public boolean isAvailableSkillTree(String skill, String skillTree) {
    	for(int i=0; i<skillTree.length(); i++) {
    		if(skill.charAt(i) != skillTree.charAt(i)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
