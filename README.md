Example of Selenium/Serenity project.


Lesson 1
Testing Web Applications with Serenity. Serenity BDD. Serenity structure
links:
https://serenity-bdd.github.io/theserenitybook/latest/web-testing-in-serenity.html
https://serenity-bdd.github.io/theserenitybook/latest/page-objects.html

Serenity wrapper требует соблюдения правил структуры проекта, иначе не будет формироватся отчет
Serenity, так в проекте нам нужно использовать прослойку Steps для обработки методов классов Page.

Переинициализация клонированого проэкта с Git
Сначала нужно удалить папку git с записями истории в директории проекта (она default disabled)
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git init
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git remote add origin https://github.com/omkhrystenko/serenitySelenium.git
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git add --all
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git status
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git commit -m "initial commit"

Подвязка проэкта под IDE
Нужно переинициализировать структуру залитого проекта и подключить модули, для этого
File -> Project structure -> Modules -> Проставить разметку на папки (напр. java - Test, test.java.resourсes - Test Resourсes,
main - Sources и т.д.


Home Task #1:
Implement successfulLoginTest()
- Explore documentation for Serenity PageObject and use it to implement test scenario
- Add .gitignore and README.md to your project and share it on GitHub


Lesson 2
Using cloud web and mobile testing platforms for remote test launching (f.e. BrowserStack, SauceLabs)
1)Для запуска тестов на платформе в облаке нам нужно сначала создать свой акаунт. Так как эти платформы
платные то создаем Trial вариант.
2)Заходим в свой профайл выбираем Summary - сдесь мы видим сколько времени у нас осталось для бесплатного
запуска тестов на этом аккаунте
3)В профайле открываем закладку Settings - сдесь мы можем взять ключи "Username" и "Access Key" их
потом нужно прописать в properties RemoteDriver или передать через командную строку во время запуска тестов
(разделитель - ":").
Пример:
a) С агрегацией отчета Serenity (test может не работать поэтому мы использовали verify):
mvn clean test serenity:aggregate
-Dmaven.clean.failOnError=false
-Dmaven.test.failure.ignore=true
-Dwebdriver.remote.url=https://olehxxxxxxxxxnko1:ruMfFmLKxRh6hj78A6HH@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.driver=chrome
-Dwebdriver.remote.os=WINDOWS
-Dwebdriver.remote.os_version=10
-Dwebdriver.remote.browserstack.debug=true
-Dchrome.switches="--no-sandbox,--ignore-certificate-errors,--homepage=about:blank,--no-first-run"

b) Без агрегации отчета Serenity
mvn clean verify
-Dwebdriver.remote.url=http://kjhghgtau1:uyiyizD67oGnPsU6RsK9N@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.os="WINDOWS"
-Dwebdriver.remote.os_version="10"
-Dwebdriver.remote.driver=Chrome

Собрать отчет Serenity мы можем если у нас к проекту помимо плагинов Serenity подключен плагин
"maven-surefire-plugin". Отчет генерится из папки target -> site -> serenity -> index.html.

Home Task #2
1. Complete successfulLoginTest() using serenity approach
- use structure that we initiated during the lesson
- feel free to read Serenity documentation for more examples
2. Make sure your test is running on BrowserStack
- also make sure Serenity report is generated


Lesson 3
Serenity BDD. Gherkin language in serenity.

links:
http://thucydides.info/docs/serenity-staging/

Для подключения BDD Serenity в pom файл нужно прописать dependency "net.serenity-bdd.serenity-jbehave".

Serenity BDD проект строится на базе gherkin language (GIVEN - WHEN - THEN). Для описания функционала
тест кейса в директории src -> test -> resources (для подвязки к папке test, правый клик на resources ->
Mark Directory as -> Test Resources Root) создаем пакет "story", а в нем файл "login" с разрешением
".story", Intelij предложит нам установить плагин для чтения файлов с таким разрешением из перечня
плагинов выбираем плагин Khumar. Синтаксис файла login.story должен подсвечиватся плагином.

Home Task #3:
- Install Doker for Windows
- Make sure you have privileges to run selenoid binaries

https://medium.com/@Volirik/%D0%BA%D0%B0%D0%BA-%D1%83%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%82%D1%8C-%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-docker-%D0%BD%D0%B0-windows-1f430c82732e


Lesson 4
Docker. Selenoid.

links:
https://aerokube.com/selenoid/latest/
https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/
https://github.com/aerokube/cm/releases/tag/1.6.0
https://aerokube.com/cm/latest/

Selenoid is a kind of Selenium Hub (separate utility for selenium that allows you to work remotely).
(F.e. Selenium hub is installed on separate server with linux and gives us its URL and port, and using
this data in driver properties on our computer we can run tests on selenium hub server from our computer
with Windows). Selenium hub gives us opportunity to divide code and browsers to separate computers.

Docker allows you to implement different OS virtual machines on the server where selenium hub was installed.
G.G.R. (kind of Selenoid for launching on CMD project)

- Установка Docker на Windows происходила через файл DockerToolbox.exe скачанный по ссылке которую прислали в Home Task #3
запуск доккера через иконку на рабочем столе DockerToolbox однако она не у всех заработала.

Витек устанавливал Docker с официального сайта для его установки сначала нужно зарегистрироваться на https://www.docker.com/
-> Sign In -> Create Account -> Ввести Docker ID (как бы свой ник в системе), почту и пароль. (Позже данные должны
понадобится при установке Docker)
Также нужно скачать установочный файл для своей ОС. Установка доступна из своего профайла.

- Установка Selenoid:
We use manual for install on link https://aerokube.com/selenoid/latest/ there we need to load binary
files first: Configuration Manager (link https://github.com/aerokube/cm/releases/tag/1.6.0) for Selenoid
file cm_windows_amd64.exe

a)Меняем имя скачанного файла на cm.exe и запускаем в командной строке (на win 10 - WIN + R  cmd):
> ./cm.exe selenoid start --vnc (в виндовс cm.exe selenoid start --vnc) после установки докера в ЦМД запустили скачаный эксешник через эту команду
Началось подкачивание образов доккера. Это конфигур. менеджер который 1) проверяет есть ли доккер, 2)достает образ селеноида,
команда vnc ри старте браузера дает возможность потом простматривать видео.

3)Достает образы операционных систем и браузеров (в этих образах наодится ОС Убунту и версии браузеров)
Эти образы подключаются к докеру и через докер могут взаимодействовать с селеноидом и через него с нашим кодом
cm.exe это мы переименовали скачанный файл cm_windows_amd64.exe

b)Скачиваем интерфейс для Selenoid
$ ./cm selenoid-ui start   выкачивает образы которые имеют удобный интерфейс
cm это мы переименовали скачанный файл cm_windows_amd64.exe (запускаем через коммандную строку)
Интерфейс запускается в браузере на http://localhost:8080/#/;
Команда для запуска:
docker run -d --name selenoid-ui -p 8080:8080 aerokube/selenoid-ui --selenoid-uri http://${SELENOID_HOST}:4444

В коде нужно отобразить соответствующие property и driver:

DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setBrowserName("chrome");
capabilities.setVersion("76.0");
capabilities.setCapability("enableVNC", true);
capabilities.setCapability("enableVideo", false);

RemoteWebDriver driver = new RemoteWebDriver(
    URI.create("http://localhost:4444/wd/hub").toURL(),
    capabilities
);

Или что удобнее прописать параметры запуска тестов в файле serenity.properties

serenity.project.name=Web tests.
serenity.console.colors=true
serenity.logging=VERBOSE

webdriver.driver=chrome
webdriver.remote.url=http://172.29.147.226:4444/wd/hub        
- 172.29.147.226 - это локальная айпишка Коли, заместь localhost, т.е. если он на своей машине запустил Docker то мы можем через айпишник 
его машины конектится к нему и запускать на его машине тесты с наших машин

serenity.driver.capabilities="browserName:chrome;enableVNC:true;enableVideo:true;"

chrome.switches="--start-maximized"

Home Task #4:
Run created BDD feature for Login
- Make sure proper Jbehave plugin installed in IDEA
- Follow this article to complete home Task: https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/


Lesson 5

docker ps - команда командной строки показывает запущенные в текущий момент контейнеры


selenoid ui
- раздел capabilities: в закладке select browser содержит перечень доступных браузеров
по умолчанию подтягиваются 3 браузера по 2 версии chrome, firefox, opera. Для открытия сессии выбираем нужную нам
версию браузера и нажимаем create session в разделе stats запустится контейнер с указанной версией браузера.

- раздел stats: содержит в себе открытые сессии, а также показывает какое количиство сессий еще можно открыть
(максимум 5 сесий на одной машине с доккером, если хотим открыть больше то нужно запускать еще одну машину с доккером
и на ней сможем открыть еще пять, для управления несколькими машинами с доккерами используется специальный UI,
который предусматривает возможность умравления контейнерами на нескольких машинах, а также администрирование
доступами к тому или иному количеству контейнеров разными юзерами, которые будут пытаться присоединиться к нему.)

- раздел videos - ранилище видео прохождения тестов.

В UI можно запускать автотесты через указанеие линки, напр. указаная в serenity.properties 
(webdriver.remote.url=http://172.29.147.226:4444/wd/hub),
а также пользоваться браузером вручную, для етого нужно в окошке сессии нажать Manual session и в открывшемся окне
нажать на синий кружок вверху окна экрана сессии (разблокировать экран для использования вручную).

Три круга - кнопки сверху экрана сессии это: красная - закрыть екран сессии; синяя - разблокировать экран для использования вручную;
зеленая - свернуть/развернуть экран сессии.
Экран сесии делится пополам, слева открывается крнтейнер с браузером и ос(которая недоступна для использования) и
справа черный экран с командами.

По умолчанию у нас загружается ОС ubuntu и браузеры по умолчанию в двух последних версиях (chrome, firefox и opera).
Как правило считается что ели тест кейсы будут проходить в браузере на одной ОС то в 95% подобных случаев они пройдут
и на других ОС, поэтому если у нас ограниченные русурсы и заказчик не насаивает на тестировании на другой ОС то тестирование
проводится на ubuntu на нужной версии браузера или же нужно дополнительно устанавливать контейнер с необходимой нам ОС

Если загруженные по умолчанию имеджи версий браузера нам не подходят и нам нужно загрузить другую нужную нам версию браузера
то нам нужно выполнить следующие действия:

- в директории юзера C:\Users\Dell\.aerokube\selenoid хранится папка browser.json в нем прописаны браузеры и их версии
для закачки селеноидом, если мы хотим закачать себе браузер соотв. версии добавляем его туда.
Чтобы его подгрузить в селеноид нам нужно выкпчать этот имедж и перезапустить контейнер.
Пример с порядком действий на Unix (на Windows должно быть также + нюансы):

Add new docker image on flight:
1) nano ~/.aerokube/selenoid/browsers.json     - открываем файл на редактирование в командной строке Unix, ручками добавили новый имедж 
                                               в файл browser.json "selenoid/chrome:74.0" по примеру предыдущих имеджей в файле browser.json
2) docker pull <new_image_name>                - выкачивает этот имедж (выкачивает слоями, некоторые слои могут уже быть и поэтому он его
                                                 быстро выкачивает) например docker pull selenoid/chrome:74.0 --vnc если с vnc то имедж 
                                                 тяжелее но позволяет просматривать видео.

3) docker kill -s HUP selenoid                 - мы убиваем предыдущий контейнер селеноид и он поумолчанию хочет переустановиться. После 
                                                  переустановки и обновления UI он должен появится в интерфейсе селеноид
4) docker logs -f selenoid                     - если что - то не завелось можно почитать логи
5) docker inspect selenoid                     - можно зайти внутрь контейнера и посмотреть что там


Может быть ошибка:
{"status":13,"value":{"message":"create container: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?"}}
Нужно настраивать какие-то переменные и насторйки. Коля не сказал. Сказал что погуглит.


Для запуска автотестов на докере сначала нам нужно закрыть все сесии в UI что бы были доступные места для сесии автотестов.
Также нужно подготовить файл serenity.properties

serenity.project.name=Web tests.
serenity.console.colors=true
serenity.logging=VERBOSE

webdriver.driver=chrome
webdriver.remote.url=http://172.29.147.226:4444/wd/hub        - 172.29.147.226 - это локальная айпишка Коли, заместь localhost

serenity.driver.capabilities="browserName:chrome;enableVNC:true;enableVideo:true;"

chrome.switches="--start-maximized"

После того как все готово. Просто запускаем тест и он должен отобразится в соответствующей сессии на Selenoid UI,
если открыть экран сессии то мы сможем увидеть прохождение нашего теста.

