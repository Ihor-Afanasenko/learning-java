package com.hillel.set.impl;

import java.util.HashSet;
import java.util.Set;

public class WorkWithTwoSet {
	private Set<Integer> firstSet;
	private Set<Integer> secondSet;

	public WorkWithTwoSet(Set<Integer> firstSet, Set<Integer> secondSet) {
		this.firstSet = firstSet;
		this.secondSet = secondSet;
	}

	public HashSet<Integer> intersectionTwoSet() {
		HashSet<Integer> result = new HashSet<>();
		for (Integer element : getSecondSet()) {
			if (!getFirstSet().add(element)) {
				result.add(element);
			}
		}
		return result;
	}

	public HashSet<Integer> unionTwoSet() {
		HashSet<Integer> resultUnion = new HashSet<>();
		resultUnion.addAll(getFirstSet());
		for (Integer element : secondSet) {
			if (getFirstSet().add(element)) {
				resultUnion.add(element);
			}
		}
		return resultUnion;
	}

	public Set<Integer> getFirstSet() {
		return firstSet;
	}

	public Set<Integer> getSecondSet() {
		return secondSet;
	}
}
