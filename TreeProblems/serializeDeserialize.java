public class Codec {
    // Encodes a tree to a single string.
    public Queue<TreeNode> qNodes = new LinkedList<TreeNode>();
    public String serialize(TreeNode root) {        
        StringBuilder result = new StringBuilder();
        if (root == null){return result.append("n").toString();}        
        qNodes.add(root);        
        while(!qNodes.isEmpty()){
            TreeNode tempNode = qNodes.remove();
            if(tempNode != null){
                result.append(tempNode.val).append(",");
                qNodes.add(tempNode.left);
                qNodes.add(tempNode.right);                
            }else{
                result.append("n").append(",");                
            }                        
        }
        return result.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {       
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(data.split(",")));        
        String val = list.get(0);
        TreeNode root = val.equals("n")?null:new TreeNode(Integer.parseInt(val)); 
        if(root == null){return null;}
        qNodes.add(root);        
        int i = 1;
        while(!qNodes.isEmpty()){
            int sz = qNodes.size();
            for(int j = 0; j < sz; j++){
                TreeNode temp = qNodes.poll();
                if(temp != null){
                    if(i < list.size() && !list.get(i).equals("n")){
                        temp.left = new TreeNode(Integer.parseInt(list.get(i++)));
                        qNodes.offer(temp.left);
                    }else{
                        i++;
                    }
                    if(i < list.size() && !list.get(i).equals("n")){
                        temp.right = new TreeNode(Integer.parseInt(list.get(i++)));
                        qNodes.offer(temp.right);
                    }else{
                        i++;
                    }                                    
                }              
            }            
        }
    return root;
    }
}
