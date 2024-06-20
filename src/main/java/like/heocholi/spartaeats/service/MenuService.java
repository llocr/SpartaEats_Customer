package like.heocholi.spartaeats.service;

import like.heocholi.spartaeats.dto.MenuResponseDto;
import like.heocholi.spartaeats.dto.ResponseMessage;
import like.heocholi.spartaeats.entity.Menu;
import like.heocholi.spartaeats.entity.Store;
import like.heocholi.spartaeats.repository.MenuRepository;
import like.heocholi.spartaeats.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    public MenuResponseDto getMenu(Long storeId, Long menuId) {
        findStoreById(storeId);
        Menu menu = menuRepository.findByStoreIdAndId(storeId,menuId).orElseThrow(() -> new IllegalArgumentException("음식점에 해당 메뉴가 존재하지 않습니다."));

        return new MenuResponseDto(menu);
    }

    public List<MenuResponseDto> getMenus(Long storeId) {
        Store store = findStoreById(storeId);

       return menuRepository.findAllByStoreId(storeId).stream().map(MenuResponseDto::new).toList();
    }




    public Store findStoreById(Long storeId) {
        Store store =storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("선택한 음식점이 존재하지 않습니다."));

        return store;
    }


}
