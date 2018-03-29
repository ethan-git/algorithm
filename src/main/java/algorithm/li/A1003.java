/*******************************************************************************
 * Copyright (c) 2017 ejpark.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 * 
 * Contributors:
 *     eungjun11@gmail.com - initial API and implementation
 ******************************************************************************/

package algorithm.li;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ejpark
 *
 */
public class A1003 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = line.charAt(j) - 48;
			}
		}
		int m = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int position = graph[i][j];
				if(position==1) {
					List<Integer> nodeList = map.get(i);
					if(nodeList == null) {
						nodeList = new ArrayList<Integer>();
						map.put(i, nodeList);
					}
					nodeList.add(j);
				}
			}
		}
		List<Node> list = new ArrayList<Node>();
		for(int i=0; i<n; i++) {
			Node node = new Node();
			node.setDepth(0);
			node.setType(i);
			List<Integer> edgelist = map.get(i);
			addChild(node, edgelist, 0, map, m);
			list.add(node);
		}

		boolean isCycle = false;
		for(Node root : list) {
			System.out.println("RootNode:"+root);
			int mDepthType = getType(root, m, root.getType());
			if(mDepthType == 1) {
				isCycle = true;
				break;
			}
		}
		
		if(isCycle) {
			System.out.println(1);			
		}else {
			System.out.println(0);
		}
		// O(n+(n*(n-1))
	}

	private static int getType(Node node, int depth, int root) {
		System.out.println("node:"+node);
		System.out.println("depth:"+ depth+", root:" + root);
		if(node.getDepth() == depth && node.getType() == root) {
			return 1;
		}
		List<Node> nodeList = node.getChildren();
		for(Node child :nodeList) {
			return getType(child, depth, root);
		}
		return 0;
	}
	
	private static void addChild(Node node, List<Integer> edgelist, int depth, Map<Integer, List<Integer>> map, int max) {
		depth++;
		for(int edge : edgelist) {
			Node child = new Node();
			child.setDepth(depth);
			child.setType(edge);
			node.addNode(child);
			if(depth < max) {
				addChild(child, map.get(edge), depth, map, max);				
			}
		}
	}
	
	static class Node {
		int type;
		int depth;
		List<Node> nodeList = new ArrayList<Node>();
		
		public void setType(int type) {
			this.type = type;
		}
		
		public void setDepth(int depth) {
			this.depth = depth;
		}
		
		public void addNode(Node node) {
			this.nodeList.add(node);
		}
		
		public void addAll(List<Node> nodelist) {
			this.nodeList.addAll(nodelist);
		}

		public int getType() {
			return this.type;
		}

		public int getDepth() {
			return this.depth;
		}

		public List<Node> getChildren(){
			return nodeList;
		}

		public String toString() {
			return String.format("[type:%s, depth:%s, child:%s]", type, depth, nodeList);
		}
	}
}
