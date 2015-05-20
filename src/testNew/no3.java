package testNew;

import java.util.LinkedList;

class TNode{
	String value;
	TNode left,right;
	public TNode(String s){
		this.value = s;
	}
}

public class no3 {
	
	private TNode root = null;
	private static LinkedList<TNode> list = null;
	
	/**
	 * 创建二叉树
	 * @param str
	 * @return
	 */
	public TNode createTree(String[] str){
		list = new LinkedList<TNode>();
		if(str == null ){
			return null;
		}
		for(int i=0;i<str.length;i++){
			list.add(new TNode(str[i]));
		}
		for(int j=0;j<str.length/2-1;j++){
			list.get(j).left = list.get(j*2+1);
			list.get(j).right = list.get(j*2+2);
		}
		int k = str.length/2-1;
		list.get(k).left = list.get(k*2+1);
		if(str.length%2 == 1){
			list.get(k).right = list.get(k*2+2);
		}
		return list.get(0);
	}
	
	/**
	 * 返回树的第n层所有节点
	 * @param tree
	 * @param n
	 * @return
	 */
	public String TreeLevel(TNode tree , int n){
		if(n<1 || n>3){
			return "Error";
		}
		if(tree == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if(n == 1){
				sb.append(tree.value);
				sb.append(" ");
		}else{
			sb.append(TreeLevel(tree.left , n-1));
			sb.append(TreeLevel(tree.right , n-1));
		}
		return sb.toString();
	}
	
	/**
	 * 前序遍历
	 * @param tree
	 */
	public String preTraverse(TNode tree) {
		StringBuilder sb = new StringBuilder();
		if (tree != null) {
			sb.append(tree.value);
			sb.append(preTraverse(tree.left));
			sb.append(preTraverse(tree.right));
		}
		return sb.toString();
	}
	
	/**
	 * 后序遍历
	 * @param tree
	 * @return
	 */
	public String postTraverse(TNode tree) {
		StringBuilder sb = new StringBuilder();
		if (tree != null) {
			sb.append(postTraverse(tree.left));
			sb.append(postTraverse(tree.right));
			sb.append(tree.value);
		}
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no3 no = new no3();
		String[] str = {"A","B","D","G","H"};
		//创建二叉树
		no.root = no.createTree(str);
		
		//前序遍历
		String strQ = no.preTraverse(no.root);
		System.out.println(strQ);
		
		//后序遍历
		String strH = no.postTraverse(no.root);
		System.out.println(strH);		
		
		//获取第n层的所有节点值
		String strN = no.TreeLevel(no.root , 3);
		System.out.println(strN);
	}

}
