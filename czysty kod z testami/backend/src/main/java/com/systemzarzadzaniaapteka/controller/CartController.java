package com.systemzarzadzaniaapteka.controller;

import com.systemzarzadzaniaapteka.model.Cart;
import com.systemzarzadzaniaapteka.model.AppUser;
import com.systemzarzadzaniaapteka.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.systemzarzadzaniaapteka.security.CustomOidcUser;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<?> getCart(@AuthenticationPrincipal CustomOidcUser customUser) {
        if (customUser == null) {
            return ResponseEntity.status(401).body("User not authenticated");
        }
        AppUser user = customUser.getAppUser();
        return ResponseEntity.ok(cartService.getOrCreateCart(user.getId()));
    }
    @PostMapping("/add")
    public Cart addItem(@AuthenticationPrincipal CustomOidcUser customUser,
                        @RequestParam Long productId,
                        @RequestParam int quantity) {
        AppUser user = customUser.getAppUser();
        return cartService.addItemToCart(user, productId, quantity);
    }

    @DeleteMapping
    public void clearCart(@AuthenticationPrincipal CustomOidcUser customUser) {
        AppUser user = customUser.getAppUser();
        cartService.clearCart(user.getId());
    }}

