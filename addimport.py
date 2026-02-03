import os

for root, dirs, files in os.walk("."):
    for file in files:
        if file.endswith(".java"):
            file_path = os.path.join(root, file)
            with open(file_path, 'r', encoding='utf-8') as f:
                content = f.read()
            if "import java.util.*;" not in content:
                with open(file_path, 'w', encoding='utf-8') as f:
                    f.write("import java.util.*;\n" + content)