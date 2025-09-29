# The Search for Satoshi — Java Text Adventure (Zuul)

A GUI-based single-player adventure in **Java** (Zuul variant).  
You are an IMF investigator hunting **Satoshi Nakamoto** across a village. Explore rooms, manage inventory and weight, collect **3 keys**, unlock a **trapdoor**, navigate a **teleporter** and a **random transporter room**, then reach the **Bitcoin Temple** to press the kill-switch. A **move counter** acts as a timer—win fast or lose.

## Highlights
- Swing **GUI** with command buttons and room illustrations
- **Inventory** with weight limit (boost via magic cookie)
- **Locked door** requiring 3 keys (success/failure messages)
- **Beamer** (charge/fire) and **TransporterRoom** (random exit)
- `back` with a **stack** (multi-step backtracking)
- Clean OOP: `Room`, `Player`, `Item`, `ItemList`, `Door`, `Beamer`, `RoomRandomizer`
- Javadoc + small test scripts for command sequences

## Run
Open in your IDE (or BlueJ), build, and run `Game`/`GameEngine`.  
Images live in `/Images`, map in `/Images/map.png`.  
Commands include: `go`, `take`, `drop`, `inventory`, `eat`, `back`, `charge Beamer`, `fire Beamer`, `stopBTC`.

## Docs
- Report (FR): see `/files/rapport_zuul_satoshi.pdf`
