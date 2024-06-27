[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/oguzkhan/modularized-hexagonal-and-clean-architecture/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-tr-red.svg)](https://github.com/oguzkhan/modularized-hexagonal-and-clean-architecture/blob/master/README.tr.md)

## MODÜLLEŞTİRİLMİŞ HEXAGONAL VE CLEAN MİMARİ

#### GİRİŞ
Bu proje Hexagonal Mimari'nin genellikle uygulanandan daha modüler bir şekilde implement edilmesine odaklanmış, programlama dili olarak Java 17, infrastructure framework'ü olarak da Spring Boot'un kullanıldığı örnek bir projedir. Event Driven Mimari (EDA) modüllerin birbirinden bağımsız hale getirilmesinde faydalı bir yaklaşım olsa da hexagonal tasarımın bir unsuru değildir ve bu projede kapsam dışı bırakılmıştır. Konuların daha iyi anlaşılabilmesi ve birbirine karışmaması adına ileriki adımlarda projeye eklenecek veya başka bir örnek proje kapsamında implement edilecektir. Bu projede `portlar` ve `adaptörler ` kullanılarak `infrastructure kodu` ile `application core` net bir biçimde birbirinden ayrılmış ve application core içindeki infrastructure framework bağımlılıkları kaldırılmıştır. Bunlar hexagonal mimarinin temel taşlarıdır. Bu projede ayrıca hexagon olarak tabir edilen application core kısmı Clean Mimaride de uygulanan `application (usecase)` ve `domain (entity)` modüllerine bölünmüştür. Projede ayrıyeten her bir hexagon katmanını kapsayacak şekilde dikine dilimlemeyi temsilen `işlev kümesi` modülleri oluşturulmuştur. Örnek proje işlev olarak film endüstrisinin temsili isterlerini gerçekleştiren servislerin bileşiminden oluşmaktadır.

#### GELİŞTİRİCİ
Bu proje `Mehmet Oğuzhan Özavar` tarafından eğitim ve araştırma amacıyla geliştirilmiştir ve MIT lisansına tâbîdir. Herhangi bir sorunuz veya görüşünüz için `hanoguz@gmail.com` adresinden Oğuzhan'a ulaşabilirsiniz.

#### SIRADAKİ İYİLEŞTİRMELER
Hexagonal Mimari ile ilgili teorik açıklamalar ve proje kodunun daha ayrıntılı anlatımını içeren içerikler halen geliştirme aşamasındadır ve tamamlandığında paylaşılacaktır. Bununla bilikte Event Tabanlı Mimari, işlev kümeleri arasındaki bağımlılıkların yönetimi, katmanlar arasındaki bağlımlılıkların yönetimi, unit testler gibi işlevlerin de eklenmesi planlanmıştır. Sizlerden gelecek istekler de önceliklendirilecektir.

<br>

### PROJENİN MİMARİSİ

#### ÜST SEVİYE MODÜLLER
`filming` maven modülü bir servisi (modüler monolith veya microservice) temsil etmektedir. `application`, `domain` ve `infra` katmanları filming modülünün alt modülleridir. `infra` modülünün `bootstrap` adında özel bir alt modülü varıdır ve tüm modülleri biraraya getirerek servisin ayağa kaldırılması işlevini üstlenir. `bootstrap` modülü bir Spring Boot uygulamasıdır ve tüm modülleri içeren build ve repackage işlemleri ile uygulamanın koşturulması işlevlerini yürütür.

#### İŞLEV KÜMESİ MODÜLLERİ
Her bir hexagonal mimari katmanına ait modül alt modüllere ayrılmıştır ve bunlar birer `işlev kümesi`'ni temsil edecek şekilde rest endpoint'leri sunarlar. Her bir işlev kümesi, katmanlar altındaki karşılık gelen modülleri ile birlikte kolaylıkla dışarı çıkartılarak ayrı bir servis modülü haline getirilebilecek durumdadır. Bu yaklaşım sayesinde her bir servis modüler monolith olarak başlatılıp, bunun altında tanımlanan işlev kümeleri ise microservice'e dönüşmesine ihtiyaç duyulan son ana kadar ana servisin içindeki modüller halinde yaşamaya devam edebilirler. Domain, Application ve Infra altında modül kırılımına gidilmesi aynı zamanda işlev kümeleri arasındaki bağımlılıkların yönetilmesi ve denetlenmesi için bir takım araçlar kullanılabilmesini de mümkün kılar. Modül bağımlılıklarının tanımlanacağı policy'ler üzerinden hexagonal mimarinin öngördüğü dıştan içe doğru tek yönlü bağımlılık ilkesinin `(infra -> application -> domain)` mecburi hale getirilmesi için bu örnek projenin yapılacaklar listesine bir ekleme yapılabilir.

#### INPUT DOĞRULAMASI
Input'ların hangi kurallara göre doğrulanması gerektiğinin tanımlanması iş kuralları kapsamında olduğu için infrastructure katmanında yer alan rest controller'larda değil, merkezi olarak application katmanında tanımlanmıştır. Application layer'da bu tanımlamaları kolaylaştırmak amacıyla `JSR-303` validation annotation'ları kullanılmış ancak doğrulamanın koşturulması işlemi infra katmanındaki validation adaptörüne yaptırılmıştır. Bu sayede input doğrulamanın iş kurallarına bakan bacağı application layer'da merkezileştirilerek controller'lar gibi uygulamaya giriş sağlayan bileşeninlerde tekrar etmesinin önüne geçilmiştir. Doğrulama işleminin infra katmanına havale edilmesi ile de application modülünün validator framework bileşenlerinden bağımsız halde olması sağlanmıştır.

#### LOGLAMA VE DİKİNE KESEN İŞLEMLER
İş mantığı ile ilgil loglar Application Service içinde Logging Port vasıtası ile tanımlanır ve Infra modülündeki Logging Adaptor tarafından gerçekleştirilir. Event Tabanlı Mimari'de ise, iş kuralları ile ilgili loglama ve diğer dikine kesen işlemler Application Service'den çıkartılarak ayrı bileşenler haline getirilip Application Service tarafından fırlatılan Applicaiton Event'lere subscribe olmaları sağlanır.

<br>

### KURULUM
1. Öncelikle repo'yu lokalinize clone'layın.
2. JDK 17+ geliştirme ortamınızda ayarlanmış ve sisteme tanıtılmış olmalıdır.
3. Projenin varsayılan ayarlarında çalışması için bir Postgresql 12.5+ veritabanı sunucusunun `5433` portunda çalışır halde olması gerekir. `filming_admin` ve `filming_web` db rollerinin, filming_admin'in owner'ı olduğu `filming` schema'nın önceden oluşturulmuş olması gerekir. Dilerseniz bootstrap modülündeki dbms tanımlarını değiştirerek farklı bir dbms kullanabilirsiniz.
4. `mvn clean install` ve `mvn clean spring-boot:run` komutlarını bootstrap modülünün dizininde çalıştırarak filming servisini koşturabilirsiniz.
5. [test-execution.bat](.misc/curl/test-execution.bat) altındaki örnek curl komutlarını kullanarak filming api'ye komut gönderebilirsiniz.

<br>

### KULLANIM
- Projede yer alan konseptleri kendi uygulamalarınızda gönül rahatlığı ile kullanabilirsiniz. Repo'nun geliştiricisine proje ile ilgili görüşlerinizi, varsa bug raporlarınızı iletebilirsiniz.
- İlerde elinizin altında olmasını istiyorsanız repo'ya star verebilirsiniz. Bu yolla geliştiricinin bu repo'nun sizin için faydalı olduğunu öğrenmesini ve geliştirmelere devam etmesini sağlayabilirsiniz. 
- Keyfini sürün!


