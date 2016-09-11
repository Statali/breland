package org.server.localshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;


/**
 * The persistent class for the seller_has_place database table.
 * 
 */
@Entity
@Table(name="seller_has_place")
public class SellerHasPlace extends  AbstractPersistable<Long> {
	/*private static final long serialVersionUID = 1L;*/

	@Column(name="place_id")
	private int placeId;

	//bi-directional many-to-one association to Seller
    @ManyToOne
	private Seller seller;

    public SellerHasPlace() {
    }

	public int getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
}