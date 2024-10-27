# SE_P2_backend
### For frontend, go [here](https://github.com/Noel-Hann/SE_P2_frontend/blob/main/README.md)

## Database ERD
![Screenshot 2024-09-27 175705](https://github.com/user-attachments/assets/8a6f5af0-611b-4628-b998-0219267d4de4)

## Mockup of website
[Figma Link] (https://www.figma.com/design/xyN59nahMuAO4IafTjL3Rr/Project2?node-id=0-1&t=DPa9l5wwhkoyDbT2-1)

# Introduction
### This is the backend for our Christmas wishlist application.
### This is designed to allow a user to create a wishlist of items that they hope to recieve, and look at their friends wishlists as well


# Features
### A database that includes users, items, a wishlist of items, and friendships between users
### CRUD operations to interact with the database so a user can create and interact with their own wishlist on the user, wishlist, and item level.

# How To Use
## End Points

## User
### GET /api/user/get-all
#### Fetches all users

### GET /api/user/get/{username}
#### Fetches user by username

### POST /api/user/add
#### Adds a new user. Request 'username' and 'password' in the request body

### DELETE /api/user/remove/{id}
#### Deletes a user by their id

### PUT /api/user/update/{id}
#### updates a user by id. Requests "username", "password", and optional "isAdmin" in the request body

## Item
### GET /api/item/get-all
#### Fetches all items

### GET /api/item/get/{id}
#### Fetches an item by its ID

### POST /api/item/add
#### Adds a new item. Requires 'name', 'price', 'shortDescription', and 'type' in the request body

### PUT /api/item/update/{id}
#### Updates an item by its ID. Requires 'name', 'price', 'shortDescription', and 'type' in the request body

### DELETE /api/item/remove/{id}
#### Removes an item by its ID.

## Entry

### GET /api/entry/get-all
#### Returns all entries.

### GET /api/entry/get-all/{wishlistNum}
#### Returns entries for a specific wishlist by its number.

### GET /api/entry/get/{id}
#### Fetches a specific entry by its ID.

### POST /api/entry/add
#### Adds a new entry. Requires 'itemId' and 'wishlistNum' in the request body.

### DELETE /api/entry/remove/{id}
#### Deletes an entry by its ID.

## Wishlist

### GET /api/wishlist/get-all
#### Fetches all wishlists.

### GET /api/wishlist/get-users/{userKey}
#### Returns wishlists associated with a specific user.

### DELETE /api/wishlist/remove/{id}
#### Removes a wishlist by its ID.

### PUT /api/wishlist/update/{id}
#### Updates a wishlist by its ID. Requires 'name' and 'description' in the request body.

### POST /api/wishlist/add
#### Creates a new wishlist. Requires 'name', 'description', and 'userKey' in the request body.

## Friend

### GET /api/friend/get-all
#### Fetches all friendships.

### GET /api/friend/get/{id}
#### Fetches friends of a user by their ID.

### POST /api/friend/add
#### Adds a friendship between two users. Requires 'Id1' and 'Id2' in the request body.

### DELETE /api/friend/remove
#### Removes a friendship. Requires 'Id1' and 'Id2' in the request body.



