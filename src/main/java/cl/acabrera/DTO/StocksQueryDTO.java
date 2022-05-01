package cl.acabrera.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StocksQueryDTO {
	private String storeNameDto;
	private String productIdDto;
	private String productNameDto;
	private String quantityDto;

}
