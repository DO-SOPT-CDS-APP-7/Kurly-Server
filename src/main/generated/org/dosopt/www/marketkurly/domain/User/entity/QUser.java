package org.dosopt.www.marketkurly.domain.User.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1803331432L;

    public static final QUser user = new QUser("user");

    public final StringPath address = createString("address");

    public final ListPath<org.dosopt.www.marketkurly.domain.Cart.entity.Cart, org.dosopt.www.marketkurly.domain.Cart.entity.QCart> cart = this.<org.dosopt.www.marketkurly.domain.Cart.entity.Cart, org.dosopt.www.marketkurly.domain.Cart.entity.QCart>createList("cart", org.dosopt.www.marketkurly.domain.Cart.entity.Cart.class, org.dosopt.www.marketkurly.domain.Cart.entity.QCart.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickname = createString("nickname");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

