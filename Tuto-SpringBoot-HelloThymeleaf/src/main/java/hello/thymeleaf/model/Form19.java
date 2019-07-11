package hello.thymeleaf.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
public class Form19 {
	
	@NotNull
	 @AssertFalse
	 private Boolean assertFalse; 
	@NotNull
	 @AssertTrue
	 private Boolean assertTrue; 
	@NotNull
	 @Future
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateInFuture; 
	@NotNull
	 @Past
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateInPast; 
	@NotNull
	 @Max(value = 100)
	 private Integer intMax100; 
	@NotNull
	 @Min(value = 10)
	 private Integer intMin10; 
	@NotNull
	 @NotEmpty
	 private String strNotEmpty; 
	@NotNull
	 @NotBlank
	 private String strNotBlank; 
	@NotNull
	 @Size(min = 4, max = 6)
	 private String strBetween4and6; 
	@NotNull
	 @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{2}$")
	 private String hhmmss; 
	@NotNull
	 @Email
	 @NotBlank
	 private String email;
}
