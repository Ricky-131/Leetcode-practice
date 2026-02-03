import os

for root, dirs, files in os.walk(".", topdown=False):
    dirs[:] = [d for d in dirs if not d.startswith('.')]
    for folder in dirs:
        if folder[0].isdigit() and "." in folder:
            num_part, name_part = folder.split(".", 1)
            new_name = f"LC{num_part.strip()}_{name_part.strip().replace(' ', '_')}"
            old_path = os.path.join(root, folder)
            new_path = os.path.join(root, new_name)
            
            os.rename(old_path, new_path)
            print(f"Renamed: {folder} -> {new_name}")

            for sub_root, sub_dirs, sub_files in os.walk(new_path):
                for file in sub_files:
                    if file.endswith(".java"):
                        file_path = os.path.join(sub_root, file)
                        with open(file_path, 'r', encoding='utf-8') as f:
                            lines = f.readlines()
                        
                        content, has_import = [], False
                        for line in lines:
                            clean = line.strip()
                            if clean == "import java.util.*;":
                                if not has_import:
                                    content.append(line)
                                    has_import = True
                                continue
                            if not clean.startswith("package "):
                                content.append(line)
                        
                        final_content = [f"package {new_name};\n"]
                        if not has_import:
                            final_content.append("import java.util.*;\n")
                        final_content.extend(content)
                        
                        with open(file_path, 'w', encoding='utf-8') as f:
                            f.writelines(final_content)
                        print(f"  Updated package in: {file}")