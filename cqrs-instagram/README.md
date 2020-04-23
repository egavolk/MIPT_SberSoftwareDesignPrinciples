**CQRS. Instagram** \
Заметим, что в инстаграмме запросов на чтение намного больше, чем на публикацию. При этом любой запрос на чтение как правило намного проще любого запроса на запись. В связи с этим мы хотим полностью разделить потоки команд и потоки запросов на чтение, чтобы получить быструю работу запросов на чтение. Более  того, для ускорения чтения можно выделить несколько репликаций базы данных, в которых будет происходить только чтение, а консистентность системы будет поддерживаться своевременным копированием данных из репликаций, в которые ведется запись. Таким образом можно полностью отделить логичу чтения от логики записи и выполнять запросы на чтение очень быстро. А поскольку в телеграме чаще листают ленту, чем постят, то ускорение именно чтений кажется максимально важным. \
\
Посмотрим на основные команды и read-модели \
**Команды:**
```
class createPost {
    String text;
    int userId;
    List<File> attachments;
}
```
```
class removePost {
    int postId;
}
``` 
```
class createComment {
    int objectId;  // id объекта, к которому относится коммент
    int userId;
    String text;
}
```
```
class setLike {
    int postId;
    int userId;
    boool isLike; //true if like; false if unlike
}
```
```
class createProfile {
    String name;
    String username;
    String password;
    String email;
    String phoneNumber;
    File profilePhoto;
}
```
```
class changeUsername {
    int userId;
    String newUsername;
}
```
```
class changePassword {
    int userId;
    String newPassword;
}
```
```
class follow {
    int followerId;
    int followingId;
}
```
**Read-models:**
```
class getPostsMadeByUser : IQuery<List<Post>> {
    int userId;
}
```
```
class getFollowingPosts : IQuery<List<Post>> {
    int userId;
}
``` 
```
class getRecommendedPosts : IQuery<List<Post>> {
    int userId;
}
``` 
```
class getComments : IQuery<List<Comment>> {
    int objectId;  // id объекта, к которому относится коммент
}
```
```
class getProdileInfo : IQuery<Profile> {
    int userId;
}
```
```
class getFollowers : IQuery<List<User>> {
    int userId;
}
```
```
class getFollowing : IQuery<List<User>> {
    int userId;
}
```
```
class searchHashTag : IQuery<List<Post>> {
    String hashTag;
}
```
```
class searchProfile : IQuery<List<Profile>> {
    String username;
}
```
