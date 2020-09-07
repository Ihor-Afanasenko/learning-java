package task1v2.com.hillel.impl;

import java.util.HashSet;
import java.util.Set;

public class ProcessorTwoSet {
	private Set<Integer> first;
	private Set<Integer> second;

	public ProcessorTwoSet(HashSet<Integer> first, HashSet<Integer> second) {
		this.first = first;
		this.second = second;
	}

	public Set<Integer> intersectionTwoSet() {
		HashSet<Integer> result = new HashSet<>(getFirst());
		result.retainAll(getSecond());
		return result;
	}

	public Set<Integer> unionTwoSet() {
		HashSet<Integer> result = new HashSet<>(getFirst());
		result.addAll(getSecond());
		return result;
	}

	public Set<Integer> getFirst() {
		return first;
	}

	public Set<Integer> getSecond() {
		return second;
	}
}