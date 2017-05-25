package agreement.core.mapper;

import agreement.core.dto.UserDTO;
import agreement.core.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Radek on 13.05.2017.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromDTO(UserDTO userDTO);

    UserDTO toDTO(User user);

    List<User> fromDTO(List<UserDTO>  dtoList);

    List<UserDTO> toDTO(List<User> users);
}
