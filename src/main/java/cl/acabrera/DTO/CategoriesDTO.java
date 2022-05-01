package cl.acabrera.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriesDTO {
	private String categoryId;		//se deja String ya que es solo datos para enviar al front, vista
	private String categoryName;	//se deja String ya que es solo datos para enviar al front, vista

}
