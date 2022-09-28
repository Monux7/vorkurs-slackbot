# [Tutoren] Vorbereitung: Bot erstellen

**Aus Sicherheitsgründen dürft ihr selbst keine Bots erstellen. Stattdessen wendet euch _Josef (Crew)_ auf Slack**. Ihr benötigt dafür nur einen Namen für den Bot.

Anleitung für Tutoren:

1. Geh auf https://api.slack.com/apps/
2. Klick "Create an App", dann "from manifest"
3. Wähle den Vorkurs-Workspace aus (du musst dazu eingeloggt sein)
4. Kopiere das Manifest (s.u.) hinein und ändere den Namen
5. Schließe die Erstellung ab
6. Installiere die App in den Workspace (falls nicht sichtbar: Settings -> Install App)
7. Erstelle einen App-level Token und gib ihn an die Studierenden weiter.
    - Der Tokenname kann alles sein, z.B. "Main Token"

```yaml
display_information:
   name: Vorkurs Informatik Bot
features:
   app_home:
      home_tab_enabled: false
      messages_tab_enabled: true
      messages_tab_read_only_enabled: false
   bot_user:
      display_name: Vorkurs Informatik Bot
      always_online: false
oauth_config:
   scopes:
      bot:
         - app_mentions:read
         - channels:history
         - channels:join
         - channels:read
         - chat:write
         - commands
         - groups:read
         - links.embed:write
         - groups:history
         - im:history
settings:
   event_subscriptions:
      bot_events:
         - app_mention
         - message.im
   interactivity:
      is_enabled: true
   org_deploy_enabled: false
   socket_mode_enabled: true
   token_rotation_enabled: false

```
