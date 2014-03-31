package com.kiumiu.ca.api500px.response.collection;

import com.kiumiu.ca.api500px.primitiveDataType.CollectionShort;

public class get_collections_response {
	public CollectionShort[] collections;

	/**
	 * @return the collections
	 */
	public CollectionShort[] getCollections() {
		return collections;
	}

	/**
	 * @param collections the collections to set
	 */
	public void setCollections(CollectionShort[] collections) {
		this.collections = collections;
	}
}
