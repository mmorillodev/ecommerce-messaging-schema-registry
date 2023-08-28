# Ecommerce Messaging Schema Registry

## Publishing

Publish to maven local:

```shell
./gradlew publishToMavenLocal
```

## Schemas

### PlaceOrder

```json
{
  "customerId": "UUID",
  "couponId": "UUID",
  "shippingCost": "19.9",
  "items": [
    {
      "productId": "UUID"
    }
  ]
}
```