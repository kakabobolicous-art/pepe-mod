# How to Set Up on GitHub

## Step 1: Create Repository

1. Go to github.com
2. Click "New repository"
3. Name it: `WebTrapMod` or `web-trap-mod`
4. Add description: "Auto-place webs under enemies on hit"
5. Choose "Public" (so anyone can download)
6. Click "Create repository"

## Step 2: Upload Files

Once your repo is created, you'll see instructions. Follow these:

### Using Git (Recommended)

```bash
# Navigate to your repo folder
cd WebTrapMod-GitHub

# Initialize git
git config user.name "Your Name"
git config user.email "your@email.com"

# Add all files
git add .

# Commit
git commit -m "Initial WebTrapMod release"

# Add remote (replace YOUR_USERNAME and REPO_NAME)
git remote add origin https://github.com/YOUR_USERNAME/REPO_NAME.git

# Push to GitHub
git branch -M main
git push -u origin main
```

### Using Web Upload (Simple)

1. Go to your GitHub repo
2. Click "Add file" → "Upload files"
3. Drag all files from folder
4. Commit

## Step 3: Add Releases

### Create Release JAR

1. On your computer, run: `./gradlew build`
2. Find JAR in `build/libs/web-trap-mod-1.0.0.jar`

### Upload to GitHub

1. Go to your repo
2. Click "Releases" on right sidebar
3. Click "Create a new release"
4. Set tag to: `v1.0.0`
5. Title: "Web Trap Mod v1.0.0"
6. Add description:
   ```
   # Web Trap Mod v1.0.0
   
   Automatically places cobwebs under enemies on hit!
   
   ## Features
   - Auto web placement on hit
   - 5 second cooldown
   - Hotbar detection
   - Smart slot restoration
   
   ## How to Install
   1. Put JAR in mods folder
   2. Launch with Fabric
   3. Enjoy!
   ```
7. Drag JAR file to "Attach binaries"
8. Click "Publish release"

## Step 4: Share Repository

Your mod is now public! Share the link:

`https://github.com/YOUR_USERNAME/WebTrapMod`

People can now:
- Download the JAR from Releases
- View the source code
- Clone and modify it
- Report issues

## Optional: GitHub Actions (Auto-Build)

Create `.github/workflows/build.yml`:

```yaml
name: Build

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
      - name: Make gradlew executable
        run: chmod +x gradlew
      - name: Build
        run: ./gradlew build
```

This auto-builds every time you push!

## That's It!

Your GitHub repo is now public and people can:
✅ Download your mod
✅ See the source code
✅ Submit issues/suggestions
✅ Fork and contribute

