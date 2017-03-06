package es.onebox.rest.utils.utils;

/**
 * @author Oreste Luci
 */
public enum ResponseErrorCodesEnum {

    ERROR_1000("1000","ERROR_CODE_ERROR_REST","Error genérico"),
    ERROR_1001("1001","ERROR_CODE_ERROR_PARAMETER_REQUIRED","Error por falta de parámetro obligatorio"),
    ERROR_1003("1003","ERROR_CODE_ERROR_PARAMETER_DATE","Error en el formato de parámetro de tipo fecha"),
    ERROR_1005("1005","ERROR_CODE_ERROR_CHARGES_PROMOTOR_NOT_FOUND","Error por falta de recargo de promotor"),
    ERROR_1006("1006","ERROR_CODE_ERROR_CHARGES_CHANNEL_NOT_FOUND","Error por falta de recargo de canal"),
    ERROR_1007("1007","ERROR_REST_DELIVERY_METHOD_NOT_FOUND","Método de entrega no reconocido"),
    ERROR_1008("1008","ERROR_CODE_ERROR_PARAMETER_FORMAT","Formato de parámetro erróneo"),
    ERROR_1009("1009","ERROR_CODE_ERROR_PARAMETER_VALUE_NOT_ALLOWED","Valor de parámetro no permitido"),
    ERROR_1010("1010","ERROR_REST_AUTHENTIFICATION_INVALID","Error de autenticación"),
    ERROR_1011("1011","ERROR_REST_AUTHENTIFICATION_INVALID_USER","Error de autenticación, usuario no válido"),
    ERROR_1012("1012","ERROR_REST_AUTHENTIFICATION_INVALID_ROLES","Error de autenticación, roles no válidos"),
    ERROR_1013("1013","ERROR_REST_AUTHENTIFICATION_INVALID_CHANNEL","Error de autenticación, canal no válido"),
    ERROR_1014("1014","ERROR_REST_AUTHENTIFICATION_INVALID_TERMINAL","Error de autenticación, terminal no válido"),
    ERROR_1015("1015","ERROR_REST_CHANNEL_CONFIGURATION_INCORRECT","Error en la configuración del canal"),
    ERROR_1016("1016","ERROR_REST_TERMINAL_CONFIGURATION_INCORRECT","Error en la configuración del terminal"),
    ERROR_1017("1017","ERROR_REST_POS_CONFIGURATION_INCORRECT","Error en la configuración del punto de venta"),
    ERROR_1018("1018","ERROR_REST_LOGIN_ERROR","Error en la identificación del usuario"),
    ERROR_1019("1019","ERROR_REST_LOGIN_USER_NOT_ACTIVE","Usuario no activo"),
    ERROR_1020("1020","ERROR_REST_MASTERDATA_COUNTRY_NOT_FOUND","Código de país incorrecto"),
    ERROR_1031("1031","ERROR_REST_EVENT_NOT_AVAILABLE","Evento no disponible"),
    ERROR_1032("1032","ERROR_REST_EVENT_NOT_PUBLISHED","Evento no publicado"),
    ERROR_1033("1033","ERROR_REST_EVENT_NO_TICKET_TEMPLATE","Plantilla de ticket no configurada"),
    ERROR_1034("1034","ERROR_REST_EVENT_CANCELED","Evento cancelado"),
    ERROR_1035("1035","ERROR_REST_EVENT_DELETED","Evento eliminado"),
    ERROR_1036("1036","ERROR_REST_EVENT_FINISHED","Evento finalizado"),
    ERROR_1037("1037","ERROR_REST_EVENT_UNREALIZED","Evento no realizado"),
    ERROR_1038("1038","ERROR_REST_EVENT_CHANNEL_NOT_ACCEPTED","Solicitud de venta no aceptada"),
    ERROR_1039("1039","ERROR_REST_EVENT_TYPE_INCORRECT","Tipo de evento incorrecto"),
    ERROR_1040("1040","ERROR_REST_SESSION_NOT_FOUND","Sesión/Abono no encontrada"),
    ERROR_1041("1041","ERROR_REST_SESSION_NOT_AVAILABLE","Sesión/Abono no disponible"),
    ERROR_1042("1042","ERROR_REST_SESSION_NOT_PUBLISHED","Sesión/Abono no publicado"),
    ERROR_1043("1043","ERROR_REST_SESSION_NOT_FOR_SALE","Sesión/Abono no está a la venta"),
    ERROR_1044("1044","ERROR_REST_SESSION_LIMIT_EXCEEDED","Limite de sesión superado"),
    ERROR_1045("1045","ERROR_REST_SESSION_SEATMAP_NOT_GRAPHIC","Aforo no gráfico"),
    ERROR_1046("1046","ERROR_REST_SESSION_SEATMAP_VIEW_NOT_FOUND","Vista del aforo no existe"),
    ERROR_1047("1047","ERROR_REST_SESSION_SEAT_NOT_AVAILABLE","No ha sido posible recuperar la información de las localidades"),
    ERROR_1048("1048","ERROR_REST_SESSION_SEAT_EXTENDED_STATUS_NOT_AVAILABLE","Asiento no disponible"),
    ERROR_1049("1049","ERROR_REST_SESSION_GROUPS_OR_INDIVIDUAL_NOT_ALLOWED","Estado extendido de asientos no disponible"),
    ERROR_1050("1050","ERROR_REST_SHOPPINGCART_EXPIRED_OR_NOT_FOUND","Carrito de compra caducado o no existe"),
    ERROR_1051("1051","ERROR_REST_SHOPPINGCART_CHANNEL_RESERVED_SEATS_LIMIT_EXCEEDED","Límite de reservas de asientos por canal superado"),
    ERROR_1052("1052","ERROR_REST_SHOPPINGCART_NOT_ENOUGH_AVAILABLE_SEATS","Insuficientes asientos libres"),
    ERROR_1053("1053","ERROR_REST_SHOPPINGCART_SEATS_NOT_AVAILABLE","Asientos no disponibles"),
    ERROR_1054("1054","ERROR_REST_SHOPPINGCART_BESTSEATS_SOLUCION_NO_ENCONTRADA","Asignación automática no encontrada"),
    ERROR_1055("1055","ERROR_REST_SHOPPINGCART_SEAT_NOT_ON_CART","Asiento no existe en el carro de la compra"),
    ERROR_1056("1056","ERROR_REST_SHOPPINGCART_GROUP_NOT_FOUND","Colectivo no encontrado"),
    ERROR_1057("1057","ERROR_REST_SHOPPINGCART_MULTIPLE_EXTERNAL_TOKEN","Error con la integración del carro con sistema externo"),
    ERROR_1058("1058","ERROR_REST_SHOPPINGCART_SEMAPHORE_ACQUISITON","Error por bloqueo de semaforo"),
    ERROR_1060("1060","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_CODE_NOT_FOUND","Código promocional no encontrado"),
    ERROR_1061("1061","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_CODE_INCORRECT","Código promocional incorrecto"),
    ERROR_1062("1062","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_USER_INVALID","Usuario de validación de promoción o descuento no válido"),
    ERROR_1063("1063","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_USER_PASSWORD_INVALID","Usuario y/o contraseña validación de promoción o descuento no válido"),
    ERROR_1064("1064","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_NOT_FOUND","Promoción o descuento no encontrado"),
    ERROR_1065("1065","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_LIMIT_EVENT_EXCEEDED","Límite máximo de promoción o descuento superado"),
    ERROR_1066("1066","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_MIN_LIMIT_NOT_REACHED","Límite máximo de promoción o descuento por operación no alcanzado"),
    ERROR_1067("1067","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_GROUP_NEEDED","Requerido colectivo de promoción o descuento"),
    ERROR_1068("1068","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_LIMIT_SESSION_EXCEEDED","Validación de colectivo requerida"),
    ERROR_1069("1069","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_NOT_APPLICABLE","Promoción o descuento no aplicable"),
    ERROR_1070("1070","ERROR_REST_SHOPPINGCART_INVITATION_NOT_PRESENT","Invitación no encontrada"),
    ERROR_1071("1071","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_REQUIRED","Falta aplicar promoción obligatoria"),
    ERROR_1072("1072","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_LIMIT_OPERATION_EXCEEDED","El límite por operación de la promoción se ha superado"),
    ERROR_1073("1073","ERROR_REST_SHOPPINGCART_PROMOTION_OR_DISCOUNT_GROUP_NOT_FOUND","Colectivo no encontrada"),
    ERROR_1080("1080","ERROR_REST_ORDER_NOT_FOUND","Pedido no encontrado"),
    ERROR_1081("1081","ERROR_REST_ORDER_INVALID","Pedido caducado"),
    ERROR_1082("1082","ERROR_REST_ORDER_NOT_ACCESSIBLE_FROM_CHANNEL","Pedido no accesible para el canal"),
    ERROR_1083("1083","ERROR_REST_ORDER_ITEM_NOT_FOUND","Pedido no accesible para el terminal"),
    ERROR_1084("1084","ERROR_REST_ORDER_NOT_ACCESSIBLE_FOR_USER","Pedido no accesible para el usuario"),
    ERROR_1085("1085","ERROR_REST_ORDER_CLIENT_DATA_MISSING","Faltan datos de cliente requeridos"),
    ERROR_1086("1086","ERROR_REST_ORDER_DELIVERY_MISSING","Falta método de entrega"),
    ERROR_1087("1087","ERROR_REST_ORDER_INVALID_STATUS","Estado de pedido incorrecto"),
    ERROR_1088("1088","ERROR_REST_ORDER_TICKETS_IN_GENERATION_PROCESS","Error en el proceso de generación de entradas"),
    ERROR_1089("1089","ERROR_REST_ORDER_TICKETS_NOT_AVAILABLE","Entradas del pedido no disponibles"),
    ERROR_1090("1090","ERROR_REST_ORDER_TICKETS_FROM_DIFFERENT_ORDERS","Entradas pertenecen a otro pedido"),
    ERROR_1091("1091","ERROR_REST_ORDER_SEARCHER","Error en la búsqueda del pedido"),
    ERROR_1092("1092","ERROR_REST_ORDER_REFUND_PAYMENTS_ERROR","Error en la transacción de pago del pedido"),
    ERROR_1093("1093","ERROR_REST_ORDER_REFUND_ITEM_ERROR","Error en la devolución"),
    ERROR_1094("1094","ERROR_REST_ORDER_TICKET_GENERATION","Error en la generación de tickets"),
    ERROR_1095("1095","ERROR_REST_ORDER_USER_DATA_REQUIRED","Faltan datos del cliente"),
    ERROR_1096("1096","ERROR_REST_ORDER_BOOKING_NOT_PERMITED","No se permite la reserva para la selección de productos que se ha realizado"),
    ERROR_1097("1097","ERROR_REST_ORDER_ISSUE_NOT_PERMITED","No se permite la emisión para la selección de productos que se ha realizado"),
    ERROR_1098("1098","ERROR_REST_ORDER_NUMBER_ITEMS_EXCEEDED","Se ha excedido el número máximo de productos para la operación"),
    ERROR_1099("1099","ERROR_REST_ORDER_NOT_PARTIALLY_REFUNDABLE","No se permiten devoluciones parciales"),
    ERROR_1100("1100","ERROR_REST_CASH_ALREADY_OPEN","La caja ya está abierta"),
    ERROR_1101("1101","ERROR_REST_CASH_IS_NOT_OPEN","La caja está cerrada"),
    ERROR_1102("1102","ERROR_REST_CASH_IS_NOT_CLOSE","La caja no está cerrada"),
    ERROR_1120("1120","ERROR_REST_PRODUCT_NOT_EXISTS","Producto no encontrado"),
    ERROR_1121("1121","ERROR_REST_PRODUCT_VARIANT_NOT_EXISTS","Variante de producto no encontrada"),
    ERROR_1122("1122","ERROR_REST_PRODUCT_VARIANT_OUT_OF_STOCK","Variante de producto fuera de stock"),
    ERROR_1130("1130","ERROR_REST_INSURANCE_NOT_AVAILABLE_OR_APPLICABLE","Seguro no disponible o no aplicable"),
    ERROR_1140("1140","ERROR_REST_MANAGER_NOT_PROMOTER","El usuario debe pertenecer a la entidad organizadora del evento"),
    ERROR_1141("1141","ERROR_REST_MANAGER_BLOCKING_REASON_NOT_FOUND","Razón de bloqueo no encontrada"),
    ERROR_1142("1142","ERROR_REST_MANAGER_NOT_ALL_SEATS_BLOCKEABLE","Hay localidades que no se pueden bloquear"),
    ERROR_1143("1143","ERROR_REST_MANAGER_NOT_ALL_SEATS_UNBLOCKEABLE","Hay localidades que no se pueden desbloquear"),
    ERROR_1144("1144","ERROR_REST_VENUE_NOT_FOUND","Recinto no encontrado"),
    ERROR_1145("1145","ERROR_REST_VENUE_WITHOUT_CALENDAR","Recinto sin calendario definido"),
    ERROR_1146("1146","ERROR_REST_VENUE_CALENDAR_WITHOUT_DATES","Recinto sin calendario para las fechas solicitadas"),
    ERROR_1150("1150","ERROR_REST_SEMAPHORE_SHOPPINGCART_LOCKED","Bloqueo por acceso concurrente al carrito"),
    ERROR_1151("1151","ERROR_REST_SEMAPHORE_ORDER_LOCKED","Bloqueo por acceso concurrente a la operación"),
    ERROR_1160("1160","ERROR_REST_ORDER_SESSION_RESTRICTION_NUMBER_ITEMS_EXCEEDED","Límite de entradas de una sesión en una misma operación superada"),
    ERROR_1161("1161","ERROR_REST_ORDER_REFUNDED","Ticket o producto ya devuelto"),
    ERROR_1162("1162","ERROR_REST_ORDER_BOOKING_NOT_MODIFIABLE","Reserva no modificable"),
    ERROR_1163("1163","ERROR_REST_ORDER_MODIFIED_BOOKING_INVALID","Orden de modificación de reserva no valida"),
    ERROR_1213("1213","ERROR_REST_ATTENDANCE_GROUP _MODIFY_WITH_TICKETS","Error al mofidicar la asistencia real de ticket de grupo"),
    ERROR_1170("1170","ERROR_REST_VISITOR_GROUP_OUT_OF_LIMITS","El grupo excede los limites"),
    ERROR_1171("1171","ERROR_REST_VISITOR_GROUP_NOT_FOUND","Grupo no encontrado"),
    ERROR_1172("1172","ERROR_REST_VISITOR_GROUP_NOT_AVAILABLE","Grupo no disponible"),
    ERROR_1173("1173","ERROR_REST_VISITOR_GROUP_IN_USE","El grupo ya esta en uso"),
    ERROR_1174("1174","ERROR_REST_VISITOR_GROUP_MODIFY_WITH_TICKETS","Error al asignar localidades al grupo"),
    ERROR_1180("1180","ERROR_REST_ATTRIBUTE_NOT_FOUND","Atributo no encontrado"),
    ERROR_1190("1190","ERROR_REST_ENTITY_NOT_FOUND","Entidad no encontrada"),
    ERROR_1200("1200","ERROR_REST_ACTIVITY_TICKET_TYPE_NOT_FOUND","Tipo de actividad no encontrada"),
    ERROR_1210("1210","ERROR_REST_ATTENDANCE_GROUP_CAN_NOT_INCREASE","La asistencia real de ticket de grupo no puede ser aumentada"),
    ERROR_1211("1211","ERROR_REST_ATTENDANCE_GROUP_HAS_NOT_FIXED_PRICE","La asistencia real de ticket de grupo no puede ser modificada si no tiene precio fijo"),
    ERROR_1212("1212","ERROR_REST_ATTENDANCE_GROUP_SESSION_HAS_NOT_DISPONIBILITY","La asistencia real de ticket de grupo no puede ser modificada por falta de disponibilidad"),
    ERROR_1270("1270","ERROR_REST_NOT_AVET_ENTITY","La entidad con la que se hace la petición debe de estar integrada con avet.");

    private final String code;
    private final String name;
    private final String description;

    private ResponseErrorCodesEnum(String code,String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
