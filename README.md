# Web Trap Mod

A simple Fabric mod that automatically places cobwebs under enemies when you hit them!

## Features

✅ **Automatic Web Placement** - Hit any mob/player and a web automatically places under them  
✅ **5 Second Cooldown** - Balanced gameplay, can't spam  
✅ **Hotbar Detection** - Automatically finds cobwebs in your hotbar (slots 1-9)  
✅ **Smart Slot Restoration** - Returns to your original hotbar position after placement  
✅ **No Configuration** - Works out of the box!  

## How It Works

1. You hit an enemy with any weapon
2. Mod detects the hit
3. Searches hotbar for cobwebs
4. Places web directly under enemy's feet
5. Switches back to your weapon
6. 5 second cooldown activates
7. Ready to place again!

## Installation

### Requirements
- Fabric Loader (0.16.0+)
- Fabric API
- Minecraft 1.21 or 1.21.5

### Steps
1. Download the latest release JAR
2. Place in your `mods` folder
3. Launch with Fabric profile
4. Done!

## Building from Source

### Requirements
- Java JDK 21+
- Gradle

### Commands
```bash
# Clone or download the repo
git clone https://github.com/pepe/web-trap-mod.git
cd web-trap-mod

# Build
./gradlew build

# Find JAR in build/libs/
```

## Customization

Edit `src/main/java/com/pepe/webtrap/WebTrapMod.java` to customize:

**Change cooldown time:**
```java
private static final long COOLDOWN_MS = 5000; // 5 seconds
// Change to 3000 for 3 seconds, etc.
```

**Change placement distance:**
```java
MathHelper.floor(victim.getY() - 1) // Change -1 to -2, etc.
```

## Compatibility

Works with:
- Other Fabric mods
- Multiplayer servers (if mods allowed)
- Modpacks
- Combat mods
- Survival and Creative mode

## License

MIT License - Feel free to modify and use!

## Author

Created by zavi pepe

---

**No complicated setup needed - just add to mods folder and go!** 🐸
