package com.hillel.set.demo;

import java.util.HashSet;

import com.hillel.set.impl.WorkWithTwoSet;

public class Demo {

	public static void main(String[] args) {
		HashSet<Integer>firstSet=new HashSet<>();
		HashSet<Integer>secondSet=new HashSet<>();
		
		firstSet.add(1);
		firstSet.add(2);
		firstSet.add(3);
		firstSet.add(4);
		firstSet.add(23);
		
		secondSet.add(1);
		secondSet.add(2);
		secondSet.add(3);
		secondSet.add(4);
		secondSet.add(5);
		secondSet.add(6);
		
		WorkWithTwoSet workFirst=new WorkWithTwoSet(firstSet,secondSet);
		
		System.out.println("Intersection two set.");
		System.out.println(workFirst.intersectionTwoSet());
		
		System.out.println("Union two set.");
		System.out.println(workFirst.unionTwoSet());
		
		

	}

}
