package org.server.localshop.services;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.server.localshop.documentmanagment.FileSystemContentRepository;
import org.server.localshop.documentmanagment.ImageData;
import org.server.localshop.domain.Trade;
import org.server.localshop.exception.ImageNotFoundException;
import org.server.localshop.repositoryclasses.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class ImageReadPlatformService
{

	private final JdbcTemplate jdbcTemplate;	
	private final TradeRepository tradeRepository;
	private final  FileSystemContentRepository contentRepository;

	@Autowired
	public ImageReadPlatformService(final JdbcTemplate jdbcTemplate, final TradeRepository tradeRepository, final  FileSystemContentRepository contentRepository) {
		this.jdbcTemplate = jdbcTemplate;
		this.tradeRepository = tradeRepository;
		this.contentRepository =contentRepository;
	}

private static final class ImageMapper implements RowMapper<ImageData> {

		public String schema() {
			return " image.id as id, image.image_path as location "
					+ " from image image , seller seller " + " where seller.image_id = image.id and seller.id=?";
		}

		public ImageData mapRow(final ResultSet rs, @SuppressWarnings("unused") final int rowNum) throws SQLException {

			final Long id = rs.getLong("id");
			final String location = rs.getString("location");
			//final Integer storageType = JdbcSupport.getInteger(rs, "storageType");
			return new ImageData(id, location);
		}
	}

	public ImageData retrieveTradeLogo(final Long sellerId) throws ImageNotFoundException {
		try {
			final Trade trade = this.tradeRepository.findOne(sellerId);

			final ImageMapper rm = new ImageMapper();

			final String sql = "select " + rm.schema();

			final ImageData imageData = this.jdbcTemplate.queryForObject(sql, rm, new Object[] { sellerId });
			final ImageData result = this.contentRepository.fetchImage(imageData);

			if (result.getContent() == null) { throw new ImageNotFoundException("clients", sellerId); }

			return result;
		} catch (final EmptyResultDataAccessException e) {
			throw new ImageNotFoundException("clients", sellerId);
		}
	}

	


}