package com.nearby.services;

import java.util.List;

import com.nearby.model.Items;

public interface SearchNearBy {

	public List<Items> searchNearBy(String at, String cat);
}
