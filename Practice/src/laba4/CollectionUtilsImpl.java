package laba4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import interfaces.task4.CollectionUtils;

public class CollectionUtilsImpl implements CollectionUtils {

	@Override
	public Collection<Integer> difference(Collection<Integer> a,
			Collection<Integer> b) {
		List<Integer> result = new ArrayList<Integer>(a);
		result.removeAll(b);
		
		return result;
	}

	@Override
	public List<Integer> intersection(Collection<Integer> a,
			Collection<Integer> b) {
		List<Integer> result = new ArrayList<>(a);
		result.retainAll(b);
		List<Integer> bCopy = new ArrayList<>(b);
		bCopy.retainAll(a);
		result.addAll(bCopy);
		return result;
	}

	@Override
	public Set<Integer> intersectionWithoutDuplicate(Collection<Integer> a,
			Collection<Integer> b) {
		Set<Integer> result = new HashSet<Integer>(a);
		result.retainAll(b);
		return result;
	}

	@Override
	public List<Integer> union(Collection<Integer> a, Collection<Integer> b) {
		List<Integer> result = new ArrayList<Integer>(a);
		result.addAll(b);
		
		return result;
	}


}
